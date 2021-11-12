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

import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll, DiagrammedAssertions, FlatSpec}

class WordNetAccessorTest extends FlatSpec with DiagrammedAssertions with BeforeAndAfter with BeforeAndAfterAll {
  "ディナー" should "夜飯、夕飯、 晩餐と同義語" in {
    val hitWords:Set[String] =  WordNetAccessor.getSynonyms("ディナー").filter(x => x.equals("夜食") || x.equals("夕飯")  || x.equals("晩餐") )
    assert(hitWords.size == 3)
  }

}

