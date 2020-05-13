import java.util

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.util.Random

object topN {
  def main(args: Array[String]): Unit = {

    val sparkconf = new SparkConf().setAppName("topN").setMaster("local[*]")
    val sc = new SparkContext(sparkconf)
    //val inputstream: RDD[String] = sc.textFile("/opt/software/xmind/maxnum.txt")
val inputstream: RDD[String] = sc.textFile("input/student.txt",4)
    inputstream.mapPartitions(ites=>{
      val datas = ites.toList
      datas.map(data=>{
        (new Random().nextInt(10),data)
      }).inits
    }).collect().foreach(println)








    val resultStream = inputstream.map(line => {
      val fieldsArr = line.split(",")
      val id = fieldsArr(0).toInt
      val name = fieldsArr(1)
      val score = fieldsArr(2).toInt
      (id, student(id, name, score))
    }).groupByKey().map(line => {
      val studentlist = line._2.toList
      val tuples = studentlist.map(student => (student.name, student.score))
      val res: List[(String, Int)] = tuples.sortBy(1 - _._2).take(3)
      res
    })
    resultStream.collect().foreach(println)
  }

}

case class student(id:Int,name:String,score:Int)