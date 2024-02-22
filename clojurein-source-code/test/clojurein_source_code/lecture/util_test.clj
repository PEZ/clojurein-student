(ns clojurein-source-code.lecture.util-test
  (:require [clojurein-source-code.common.util :as sut]
            [clojurein-source-code.lecture.util :refer [testing-with-timeout *time-out*]]
            [clojure.pprint :refer [cl-format]]
            [clojure.test :refer [deftest is testing]]))

(deftest t-find-if
  (testing-with-timeout "find-if"
    (is (= '(1) (sut/find-if odd? [1 2 3 4])))
    (is (= '(2) (sut/find-if even? [1 2 3 4])))
    (is (identical? nil (sut/find-if even? [1 3 5 7])))
    (is (= () (for [x (sut/find-if odd? [2 4 6 8])] 42)))
    ))

(deftest t-tails
  (testing-with-timeout "tails"
    (is (= '((1 2 3)
             (2 3)
             (3))
           (sut/tails '(1 2 3))))

    (is (= '()
           (sut/tails '())))))

(deftest t-member
  (testing-with-timeout "member"
    (is (= true
           (sut/member 1 '(0 1 2))))
    (is (= true
           (sut/member true '(0 true 2))))
    (is (= false
           (sut/member true '(0 1 2))))
    (is (= false
           (sut/member nil '(0 1 2))))
    (is (= false
           (sut/member nil '(0 false 2))))
    (is (= false
           (sut/member false '(0 nil 2))))
    (is (= true
           (sut/member nil '(0 nil 2))))



    (is (= true
           (sut/member 1 [0 1 2])))
    (is (= true
           (sut/member true '(0 true 2))))
    (is (= false
           (sut/member true [0 1 2])))
    (is (= false
           (sut/member nil [0 1 2])))
    (is (= false
           (sut/member nil [0 false 2])))
    (is (= false
           (sut/member false [0 nil 2])))
    (is (= true
           (sut/member nil [0 nil 2])))


    (is (= true
           (sut/member nil #{0 nil 2})))
    (is (= true
           (sut/member false #{0 false 2})))
    (is (= false
           (sut/member nil #{0 false 2})))
    (is (= false
           (sut/member false #{0 true 2})))))


(deftest t-almost-equal
  (testing-with-timeout "almost equal"
    (is (= true ((sut/almost-equal 0.01) 1.0 1.00001)))
    (is (= false ((sut/almost-equal 0.01) 1.0 2.00001)))))

