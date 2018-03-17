(ns pe2c-cljs.views
  (:require [re-frame.core :as re-frame]
            [pe2c-cljs.subs :as subs]
            ))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div "Hello from " @name]))
