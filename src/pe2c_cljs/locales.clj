(ns pe2c-cljs.locales
  (:require [clojure.edn :as edn]))

(defmacro french
  []
  (edn/read-string (slurp "resources/locales/french.edn")))

(defmacro english
  []
  (edn/read-string (slurp "resources/locales/english.edn")))
