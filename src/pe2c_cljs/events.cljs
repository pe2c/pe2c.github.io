(ns pe2c-cljs.events
  (:require [re-frame.core :as re-frame]
            [pe2c-cljs.db :as db]))

(re-frame/reg-event-db
 ::initialize-db
 (fn  [_ _]
   db/default-db))
