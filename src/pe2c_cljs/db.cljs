(ns pe2c-cljs.db
  (:require [goog.object :as object]
            [pe2c-cljs.locales :refer [t]]
            [clojure.string :as str]))

(def default-db
  (let [a (->> [101 97 115 116 101 114 45 101 103 103]
               (map char)
               (reduce str) keyword)
        b (->> [87 111 119 44 32 121 111 117 39 118 101 32 114 101 97
               100 32 116 104 97 116 33 32 84 104 105 115 32 105 115
               32 97 109 97 122 105 110 103 32 55356 57225 55356 57214
               32 87 104 97 116 32 97 98 111 117 116 32 115 101 110
               100 105 110 103 32 97 32 109 101 115 115 97 103 101 32
               116 111 32 34 112 105 101 114 114 101 45 103 101 116
               116 105 110 103 45 104 105 114 101 100 64 50 98 115 116
               46 102 114 34 63 32 67 108 111 106 117 114 101 83 99
               114 105 112 116 32 105 115 32 110 111 116 32 109 121 32
               109 97 105 110 32 102 111 99 117 115 32 97 114 101 97
               32 40 73 32 112 114 101 102 101 114 32 115 121 115 116
               101 109 115 32 119 105 116 104 32 115 101 118 101 114
               97 108 32 99 111 109 112 111 110 101 110 116 115 32 97
               110 100 32 100 105 115 116 114 105 98 117 116 101 100
               32 115 116 97 116 101 32 99 111 110 118 101 114 103 101
               110 99 101 41 32 98 117 116 32 73 39 100 32 98 101 32
               104 97 112 112 121 32 116 111 32 99 104 97 116 32 119
               105 116 104 32 121 111 117 32 55357 56841]
               (map char)
               (reduce str))]
    (assoc {}
           a b
           :window/scroll #:scroll{:x nil :y nil})))

(def members
  [{:img "img/team/geraud-de-boisset.jpg"
    :entry :geraud-de-boisset
    :position :president-associate}
   {:img "img/team/arnaud-ladrange.jpg"
    :entry :arnaud-ladrange
    :position :associate}
   {:img "img/team/pierre-niclot.jpg"
    :entry :pierre-niclot
    :position :associate}
   {:img "img/team/michel-ravet.jpg"
    :entry :michel-ravet
    :position :associate}])
