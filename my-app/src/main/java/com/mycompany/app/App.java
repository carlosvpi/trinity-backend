package com.mycompany.app;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
		SparkSession spark = SparkSession
			.builder()
			.appName("Java Spark SQL basic example")
			.master("local")
			.getOrCreate();

		Dataset<Row> df = spark.read().parquet("../../../files/part-00000-584fcd61-b0d2-4429-ac49-078fc31e950a.snappy.parquet");
		df.printSchema();
		df.createOrReplaceTempView("table");
		Dataset<Row> sqlDF;
		String input = "";
		Scanner sc = new Scanner(System.in);
		do {
			input = sc.nextLine();
			System.out.println("Type 'quit' to quit");
			if (!input.equals("quit")) {
				sqlDF = spark.sql(input); //SELECT COUNT(DISTINCT userId) FROM table
				sqlDF.show();
			}
		} while (!input.equals("quit"));

    }
}
