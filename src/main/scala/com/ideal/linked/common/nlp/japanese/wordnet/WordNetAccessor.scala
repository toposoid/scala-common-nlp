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

package com.ideal.linked.common.nlp.japanese.wordnet

import com.typesafe.scalalogging.LazyLogging
import edu.cmu.lti.jawjaw.JAWJAW
import edu.cmu.lti.jawjaw.pobj.POS

import scala.collection.JavaConverters._
import scala.util.{Failure, Try}

/**
 * Accessor for WordNet
 */
object WordNetAccessor extends LazyLogging{
  /**
   * This function returns synonyms using WordNet
   * @param word
   * @return synonyms
   */
  def getSynonyms(word:String): scala.collection.immutable.Set[String] = Try{
    val synonyms:scala.collection.immutable.Set[String] = JAWJAW.findSynonyms(word, POS.n).asScala.toSet
    return synonyms
  } match {
    case Failure(e) => throw e
  }

}
