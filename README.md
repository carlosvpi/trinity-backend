# Trinity back end

Root directory: `trinity-backend/my-app`

## Compile

`$ mvn install`

## Run

`$ java -jar target/my-app-1.0-SNAPSHOT.jar`

## Server

`http://localhost:4567/get?uniq=hola&period=day&group=publicationId`

## Examples

### http://localhost:4567/get?uniq=nothing&period=nothing&group=nothing
```
+------+
| value|
+------+
|105735|
+------+
```

### http://localhost:4567/get?uniq=uniq&period=nothing&group=nothing
```
+-----+
|value|
+-----+
|90351|
+-----+
```

### http://localhost:4567/get?uniq=uniq&period=day&group=nothing
Note that in this file there's only one day
```
+-----+----------+
|value|      time|
+-----+----------+
|90351|2017-06-21|
+-----+----------+
```

### http://localhost:4567/get?uniq=uniq&period=day&group=publicationId
```
+-----+-----+----------+
|value|group|      time|
+-----+-----+----------+
|11547|    4|2017-06-21|
| 1087|   27|2017-06-21|
|  456|   37|2017-06-21|
|42626|    2|2017-06-21|
|  352|   46|2017-06-21|
|   21|   10|2017-06-21|
|  792|   44|2017-06-21|
|  706|    3|2017-06-21|
| 3851|    1|2017-06-21|
|  700|   47|2017-06-21|
|  744|   28|2017-06-21|
|  871|   18|2017-06-21|
|   21|   12|2017-06-21|
|  762|    7|2017-06-21|
|  799|   49|2017-06-21|
|  224|   30|2017-06-21|
|  732|   50|2017-06-21|
|   82|   40|2017-06-21|
| 4947|    8|2017-06-21|
| 8387|    6|2017-06-21|
+-----+-----+----------+
only showing top 20 rows
```

### http://localhost:4567/get?uniq=uniq&period=nothing&group=publicationId
```
+-----+-----+
|value|group|
+-----+-----+
|   43|   29|
|  672|   19|
|  762|    7|
|  272|   34|
|  732|   50|
|  121|   32|
|   28|   43|
|   80|   39|
| 8387|    6|
| 1087|   27|
|  744|   28|
| 3851|    1|
|   21|   10|
|  792|   44|
|  706|    3|
|  456|   37|
|   21|   12|
| 4947|    8|
|  799|   49|
|   13|   35|
+-----+-----+
only showing top 20 rows
```

### http://localhost:4567/get?uniq=uniq&period=hour&group=publicationId
```
+-----+-----+--------+
|value|group|    time|
+-----+-----+--------+
|   76|    2|22:33:35|
|    9|    1|22:16:06|
|    4|    8|22:32:36|
|    2|   27|22:19:24|
|    1|   30|22:13:49|
|   39|    2|22:47:02|
|   21|    6|22:13:58|
|   43|    2|22:15:38|
|    3|    7|22:48:10|
|    7|    4|22:45:28|
|    8|    6|22:33:53|
|    6|   16|22:17:02|
|   38|    2|22:50:37|
|   14|    6|22:13:54|
|    2|   16|22:32:15|
|    2|    8|22:17:08|
|   11|   16|22:16:09|
|    2|    3|22:19:58|
|    8|    8|22:17:05|
|   80|    2|22:14:11|
+-----+-----+--------+
only showing top 20 rows
```