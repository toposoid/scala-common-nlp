/*
 * Copyright 2021 Linked Ideal LLC.[https://linked-ideal.com/]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ideal.linked.common.nlp.word2vec

import com.ideal.linked.common.DeploymentConverter.conf
import com.typesafe.scalalogging.LazyLogging

import java.io._
import scala.Array
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.{Failure, Success, Try}

/**
 *Word2Vec binary model accessor
 */
object Word2VecAccessor extends LazyLogging{
  //Load model
  val model = new Word2Vec()
  val projectDir:String = new File(".").getAbsoluteFile().getParent()
  if(projectDir.startsWith("/app")) {
    val modelFile = "/app/scala-common-nlp/src/main/resources/entity_vector.model.bin"
    model.load(modelFile)
  }else{
    val modelFile = projectDir.substring(0, projectDir.lastIndexOf("/")) + "/scala-common-nlp/src/main/resources/entity_vector.model.bin"
    model.load(modelFile)
  }

  /**
   * If the words are similar to each other, ture returns false otherwise
   * @param str1 word
   * @param str2 word
   * @return true/false
   */
  def calcSimilarityByWord2Vec(str1:String, str2:String): Boolean = Try {
    conf.hasPath("similarityThreshold")
    if(model.cosine(str1, str2) > getThreshold()){
      return true
    }else{
      return false
    }
  }match {
    case Failure(e) => throw e
  }

  /**
   * Get similarity threshold
   * @return float valuse
   */
  def getThreshold(): Float = Try{
    if(!conf.hasPath("similarityThreshold")) return 0.55f
    val threshold = conf.getString("similarityThreshold") match {
      case "" => 0.55f
      case _ => conf.getString("similarityThreshold").toFloat
    }
    if(threshold > 1.0) return 0.55f
    threshold
  }match {
    case Success(s) => s
    case Failure(e) => 0.55f
  }
}