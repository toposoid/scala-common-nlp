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

package com.ideal.linked.common.nlp.japanese.word2vec

import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll, DiagrammedAssertions, FlatSpec}

class Word2VecAccessorTest extends FlatSpec with DiagrammedAssertions with BeforeAndAfter with BeforeAndAfterAll{

  "ディナーとダイニング" should "同義語としての類似度が高い" in {
    assert(Word2VecAccessor.calcSimilarityByWord2Vec("ディナー", "ダイニング"))
  }
  "弊社と御社" should "同義語としての類似度が低い" in {
    assert(!Word2VecAccessor.calcSimilarityByWord2Vec("弊社", "御社"))
  }
}
