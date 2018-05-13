(ns pe2c-cljs.styles
  ;; cljc is needed. clj for lein plugin compilation, cljs for var references
  (:require [garden.units :refer [px]]
            [garden.stylesheet :refer [at-media]])
  #?(:clj
           (:require [garden.def :refer [defstyles]])
     :cljs (:require-macros [garden.def :refer [defstyles]])))

(def logo-blue-light "#80ACD1")
(def logo-blue-strong "#0068A3")
(def logo-green-light "#ECF4D8")
(def logo-green-strong "#9AC446")
(def dark-strong "#212529")

(def flex-center
  {:display :flex
   :flex-direction :row ;; explicit default, override it if need be
   :flex-wrap :wrap
   :align-items :center
   :justify-content :center})

(def length-unit
  "Basic length reference. Express stuff in relation to this so you
  don't have complete magic numbers. "
  15)

(def section-collapsed-scroll-y
  (* 3 length-unit))

(def section-collapsed
  {:background-color dark-strong})

(def section-expanded
  {:padding-top length-unit})

(def section-base
  {:transition-property [:background-color :padding :visibility]
   :transition-duration "0.4s"
   :transition-delay "0s"
   :position :fixed
   :z-index 1
   :width "100%"
   :top 0
   :right 0
   :transition-timing-function "ease-in-out"})

(def section-panel-rules
  (let [breakpoint-medium 848]
    [[:#sections-panel (merge section-base
                              flex-center)
       (at-media {:max-width (px breakpoint-medium)}
         [:& {:position :static
              :padding-top 0}])]
     [:.sections-panel-collapsed {:background-color dark-strong}
       (at-media {:max-width (px breakpoint-medium)}
         [:& {}])]
     [:.sections-panel-expanded {:padding-top (px length-unit)}
       (at-media {:max-width (px breakpoint-medium)}
         [:& {:background-color dark-strong}])]
     [:.menu-item {:padding (px length-unit)}]
     [:.menu-item-collapsed {:color logo-blue-light}]
     [:.menu-item-expanded {:color :white}
       (at-media {:max-width (px breakpoint-medium)}
         [:& {:color logo-blue-light}])]]))

(def padded-item
  {:flex 1
   :padding length-unit})

(def offer-picture
  {:object-fit :contain
   :width "100%"
   :height (* 9 length-unit)})

(def added-value-list-height
  300)

(def cover-background-image
  {:background-image "url(img/cover.jpg)"
   :background-repeat :no-repeat
   :background-attachment :scroll
   :background-position :center
   :background-size :cover})

(def get-in-touch-background-image
  {:background-color dark-strong
   :background-image "url(img/map-image.png)"
   :background-attachment :scroll
   :background-position :center
   :background-size :cover})

(def choose-us-background-image
  {:background-image "url(img/choose-us/sky-scrapers.png)"
   :background-repeat :no-repeat
   :background-attachment :scroll
   :background-position :center
   :background-size :cover})

(defn member-chip-face
  [displayed?]
  {:margin-bottom length-unit
   :border-width (/ length-unit 2)
   :border-radius "50%"
   :border-style :solid
   :border-color (if displayed?
                   logo-blue-strong
                   :white)})

(def section-heading-font-size 42)
(def large-text-font-size 42)
(def text-font-size 19)
(def small-text-font-size 14)

(def section-padding
  (* 6 length-unit))

(def section-formatting
  {:padding-top (px section-padding) ;; so content isn't hidden by 50-px-high banner
   :padding-bottom (px section-padding)
   :padding-left (px 200)
   :padding-right (px 200)
   :min-height (str "calc(100vh - " section-padding "px - " section-padding "px)") ;; INFO
   :max-width (px 2200)})

;; Here media queries are content-oriented, not media-oriented. It
;; means that breakpoints are defined for each content. Of course, I
;; also test in responsive mode to make sure it eventually works at
;; the end.
;; 
;; Min width test for responsive design: 280px. Max is 2200px (not
;; sure it's even useful but it was so easy to check I did it).

(def title-rules
  (let [breakpoint-title-large (px 1268)
        breakpoint-title-medium (px 1034)
        breakpoint-title-small (px 912)
        breakpoint-title-very-small (px 342)]
    [[:#title {}
      (at-media {:max-width breakpoint-title-small}
                [:& {:margin-top (px (* 5 length-unit))}])]
     [:#title-name {:font-size (px 28)
                    :background-color :white}
       (at-media {:max-width breakpoint-title-large}
         [:& {:font-size (px 25)}])
       (at-media {:max-width breakpoint-title-medium}
         [:& {:font-size (px 21)}])]
     [:#title-motto {:font-size (px 80)
                     :background-color :white}
       (at-media {:max-width breakpoint-title-large}
         [:& {:font-size (px 68)}])
       (at-media {:max-width breakpoint-title-medium}
         [:& {:font-size (px 56)}])
       (at-media {:max-width breakpoint-title-very-small}
         [:& {:font-size (px 42)}])]
     [:#title-logo {:height (px 360)
                    :width (px 360)
                    :background "radial-gradient(ellipse at center, rgba(255,255,255,1) 0%, rgba(255,255,255,1) 35%, rgba(255,255,255,0.31) 60%, rgba(0,0,0,0) 71%)"}
       (at-media {:max-width breakpoint-title-large}
         [:& {:height (px 250)
              :width (px 250)}])
       (at-media {:max-width breakpoint-title-small}
         [:& {:width "50%"
              :height "50%"}])
       (at-media {:max-width breakpoint-title-very-small}
         [:& {:width (px 250)
              :height (px 250)}])]]))

(def general-section-rules
  (let [breakpoint-section-medium (px 776)
        breakpoint-section-small (px 474)]
    [:section (merge section-formatting
                     flex-center
                     {:flex-direction :column})
      (at-media {:max-width breakpoint-section-medium}
        [:& {:padding-left (px 50)
             :padding-right (px 50)}])
      (at-media {:max-width breakpoint-section-small}
        [:& {:padding-left (px 10)
             :padding-right (px 10)}])]))

(def offer-rules
  (let [breakpoint-section-very-small (px 392)]
    [:.offer-bullets {:min-width (px (* 20 length-unit))}
     (at-media {:max-width breakpoint-section-very-small}
       [:& {:min-width (px 150)}])]))

(def choose-us-rules
  [[:#reasons {:background-color "#FFFFFF66"
               :padding (px length-unit)}]
   [:#reason (assoc padded-item
               :width 200)]])

(def added-value-rules
  (let [breakpoint-small (px 388)
        breakpoint-medium (px 858)]
    [(at-media {:min-width breakpoint-medium} ;; min
       [:#added-value {;; this section is rather empty, it's not a
                       ;; problem to reduce its padding.
                       :padding-left (px (* 0.5 section-padding))
                       :padding-right (px (* 0.5 section-padding))}])
     [:#added-value-ol {:height (px added-value-list-height)
                        :width "50vw"
                        :display :flex
                        :flex-direction :column
                        :justify-content :space-evenly}
      (at-media {:max-width breakpoint-medium}
                [:& {:width "100%"}])]
     [:#added-value-img {:object-fit :contain
                         :width (px added-value-list-height)
                         :height (px added-value-list-height)}
      (at-media {:max-width breakpoint-small}
                [:& {:width (px 200)
                     :height (px 200)}])]]))

(def who-we-are-rules
  (let [breakpoint-very-small (px 392)
        breakpoint-small (px 464)
        breakpoint-medium (px 1148)]
    [(at-media {:min-width breakpoint-very-small ;; min
                :max-width breakpoint-medium}
       [:#who-we-are {;; this section is rather empty, it's not a
                      ;; problem to reduce its padding.
                      :padding-left (px (* 0.5 section-padding))
                      :padding-right (px (* 0.5 section-padding))}])
     [:.member-chip (assoc flex-center
                      :margin (px 60)
                      :text-decoration :none
                      :flex-direction :column)
       (at-media {:max-width breakpoint-small}
         [:& {:margin-left (px 0)
              :margin-right (px 0)}])]
     [:.member-chip-face {:object-fit :contain
                          :width (px (* 16 length-unit))
                          :height (px (* 16 length-unit))}
      (at-media {:max-width breakpoint-very-small}
        [:& {:width "50vw"
             :height "50vw"}])]
     [:#member-biography {:position :relative
                          :top "-20vh"
                          :left (px 0)
                          :margin-bottom (px -20)
                          :height (px 20)}]]))

(def get-in-touch-rules
  (let [breakpoint-medium (px 512)]
    [[:#get-in-touch {;; this section is rather empty, it's not a problem to reduce its padding.
                      :padding-left 0
                      :padding-right 0}]
     [:#get-in-touch-link {:font-size (px large-text-font-size)}
       (at-media {:max-width breakpoint-medium}
         [:& {:font-size (px text-font-size)}])]]))

(defstyles sheet
  [:a {:text-decoration :none}]
  [:body {:margin 0
          :scroll-behavior :smooth}]

  [:h1 :h2 :h3 :h4 {:font-family "'Open Sans', sans-serif"
                       :color logo-blue-strong}]
  [:h2 {:font-size (px section-heading-font-size)}]

  section-panel-rules
  title-rules
  general-section-rules
  offer-rules
  choose-us-rules
  added-value-rules
  who-we-are-rules
  get-in-touch-rules

  [:p :div :li {:font-family "'Montserrat', sans-serif"
                :font-size (px text-font-size)}]

  ["section:nth-child(2n)" {:background-color (str logo-blue-light "18")}]
  [:#get-in-touch-link {:color logo-blue-light}
   [:&:hover {:color logo-blue-strong
              :background-color logo-blue-light}]])











