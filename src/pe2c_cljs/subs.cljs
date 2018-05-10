(ns pe2c-cljs.subs
  (:require [re-frame.core :as re-frame]
            [reagent.ratom :as ratom]
            [reagent.core :as reagent]
            [goog.object :as object]))

;;; --- rethought version

(defn scroll-listener
  [app-db e]
  (reagent/rswap! app-db (fn [app-db page-x page-y]
                           (assoc app-db
                             :window/scroll
                             #:scroll{:x page-x
                                      :y page-y}))
                  (object/get e "pageX")
                  (object/get e "pageY")))

(defonce ^:const scroll-event
  "scroll")

(defn window-scroll-handler
  [app-db & _]
  (let [event-listener (.addEventListener js/window scroll-event (partial scroll-listener app-db))]
    (ratom/make-reaction #(do (:window/scroll @app-db #:scroll{:x nil :y nil}))
      :on-dispose #(.removeEventListener js/window scroll-event event-listener))))

(re-frame/reg-sub-raw
  ::internal-window-scroll
  window-scroll-handler)

(re-frame/reg-sub
  :window/scroll-trigger
  :<- [::internal-window-scroll]
  (fn [scroll-state [_ trigger]]
    (trigger scroll-state)))

(re-frame/reg-sub
  :window/scroll
  :<- [::internal-window-scroll]
  (fn [scroll-state]
    scroll-state))

;; visible?
;; invisible?

(re-frame/reg-sub
  :displayed-biography
  (fn [db _]
    (:displayed-biography db)))
