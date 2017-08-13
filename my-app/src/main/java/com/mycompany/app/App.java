package com.mycompany.app;
import static spark.Spark.*;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import java.util.Scanner;

import com.google.gson.Gson;

public class App 
{
	private static Gson gson = new Gson();

    public static void main( String[] args )
    {
		SparkSession spark = SparkSession
			.builder()
			.appName("Java Spark SQL basic example")
			.master("local")
			.getOrCreate();

		Dataset<Row> df = spark.read().parquet("../../../files-flat/part-00000-584fcd61-b0d2-4429-ac49-078fc31e950a.snappy.parquet");
		// Dataset<Row> df = spark.read().parquet("../../../files-flat");
		df.printSchema();
		df.createOrReplaceTempView("table");
        get("/get", (req, res) -> {
        	String uniq = req.queryParams("uniq");
        	String period = req.queryParams("period");
        	String group = req.queryParams("group");
        	String query = "SELECT COUNT(";
    		String groupBy = "";
    		String periodGroupBy = "";
        	if (uniq.equals("uniq")) {
        		query += "DISTINCT ";
        	}
        	query += "userId) AS value";
        	if (!group.equals("nothing")) {
        		query += ", " + group + " AS group";
        		groupBy = " GROUP BY " + group;
        	}
        	if (!period.equals("nothing")) {
        		periodGroupBy = period.equals("day")
        			? "SUBSTR(timestamp, 1, 10)"
        			: period.equals("hour")
        			? "SUBSTR(timestamp, 12, 19)"
        			: "timestamp";
        		query += ", " + periodGroupBy + " AS time";
        		groupBy = groupBy.equals("")
        			? " GROUP BY "
        			: groupBy + ", ";
        		groupBy += periodGroupBy;
        	}
        	query += " FROM table" + groupBy;
			Dataset<Row> sqlDF = spark.sql(query);
			sqlDF.show();
			res.type("application/json");
			return sqlDF.toJSON().collect();
        });

    }
}
