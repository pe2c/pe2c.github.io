(ns pe2c-cljs.locales
  (:require [clojure.string :as str]
            [goog.object :as object]
            [cljs.reader :as reader])
  ;; So locales are computed are compilation time
  (:require-macros [pe2c-cljs.locales :as locales]))

(defn- prepend-current-to-sub-key
  [k [k1 v1]]
  [(flatten [k k1]) v1])

(defn locale-dictionary-to-tsv
  "Ease translation by non technical human. You can export this to a spreadsheet.
  (locale-to-tsv (:fr dictionary))"
  [locale-dictionary]
  (->> locale-dictionary
       (reduce (fn recursive-flatten-locale [acc [k v]]
                 (cond (map? v)
                       (->> v
                            (map (partial prepend-current-to-sub-key k))
                            (reduce recursive-flatten-locale
                                    acc))

                       (vector? v)
                       (->> v
                            (map-indexed vector)
                            (map (fn prettify-index-for-human [[k v]]
                                   [(inc k) v]))
                            (map (partial prepend-current-to-sub-key k))
                            (reduce recursive-flatten-locale acc))

                       :default
                       (conj acc [k v])))
               [])
       (reduce (fn [acc [path s]]
                 (str acc (str/join "
" path) "\t" s "\n"))
               "")))

(defn- parse-path
  [path-item]
  (if (re-matches #"\d" path-item)
    (dec (js/parseInt path-item))
    (keyword (str/join (rest path-item)))))

(def text-should-be-parsed-regex #"^#EDN_PARSE.*")

(defn- parse-text [text]
  (if (re-matches text-should-be-parsed-regex text)
    (reader/read-string (str/replace text "#EDN_PARSE" ""))
    text))

(defn tsv-file-to-locale-dictionaries
  [tsv]
  (->> (str/split tsv #"\n")
       (map #(str/split % #"\t"))
       (map (fn [[path french-text english-text]]
              ;; The tsv file has three columns: path, French text and English
              ;; text. Choose here which dictionary you want to generate.
              (let [text (or english-text "")
                    parsed-path (map parse-path (str/split path #", "))
                    parsed-text (parse-text text)]
                [parsed-path parsed-text])))
       (reduce (fn [acc [path text]]
                 ;; TODO vectors are currently rendered as map with 0, 1, 2… as keys.
                 ;; It's correct but there is a problem with the way t function handles it.
                 ;; This should be fixed.
                 (assoc-in acc path text))
               {})))

(def dictionary
  (let [french (locales/french)
        english (locales/english)]
    {"en" english
     "en-US" english
     "en-GB" english
     "fr" french
     "fr-FR" french
     "fr-BE" french}))

(def locale-fallback
  "fr")

(def *locale*
  ;; TODO: Better to use re-frame for that?
  (->> "languages"
       (object/get js/navigator)
       (filter dictionary)
       first))

(defn t
  "T as translate"
  [& path]
  ;; TODO: doesn't handle [] case, only nil
  (or (get-in dictionary (cons *locale* path))
      (do (.warn js/console (clj->js path) (str "not found in " *locale* ", fallback on " locale-fallback))
          (get-in dictionary (cons locale-fallback path)))
      (do (.warn js/console (clj->js path) (str "not found in fallback" locale-fallback ", not found at all"))
          (str "not found: " (str/join "
" path)))))
