(ns pe2c-cljs.events
  (:require [re-frame.core :as re-frame]
            [pe2c-cljs.db :as db]))

(re-frame/reg-event-db
 ::initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
  :toggle-displayed-biography
  (fn [db [_ member]]
    (update db
            :displayed-biography
            (fn [current]
              (when-not (= current member)
                member)))))
