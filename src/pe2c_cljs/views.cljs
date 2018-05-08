(ns pe2c-cljs.views
  (:require [re-frame.core :as re-frame]
            [pe2c-cljs.subs]
            [pe2c-cljs.lorem-ipsum :as lorem-ipsum]))

(defn- collapsible-sections
  []
  (let [collapsible-pred (fn [{:scroll/keys [y]}]
                           (let [threshold 50]
                             (if (<= y threshold)
                               :title/expanded
                               :title/collapsed)))
        collapsible-state (re-frame/subscribe [:window/scroll-trigger collapsible-pred])]
    (fn []
      (let [collapsible-style (case @collapsible-state
                                :title/collapsed {:background-color "#212529"
                                                  :position :fixed}
                                :title/expanded {:position :fixed
                                                 :padding-top 25
                                                 :padding-bottom 25})]
        [:div#collapsible-title {:style (merge {:transition-property [:background-color :padding]
                                                :transition-duration "0.4s"
                                                :transition-delay "0s"
                                                :color :white
                                                :width "100%"
                                                :padding-left 200
                                                :padding-right 200
                                                :transition-timing-function "ease-in-out"}
                                               collapsible-style)}
         [:div.menu-item "Nos services"]
         [:div.menu-item "Choisir PE2C"]
         [:div.menu-item "Notre valeur ajoutée"]
         [:div.menu-item "Qui sommes-nous ?"]
         [:div.menu-item "Contact"]]))))

(defn title
  []
  [:div {:style {:display :flex
                 :flex-direction :column
                 :flex-wrap :wrap
                 :align-items :center
                 :justify-content :center
                 :color :white}}
   [:h1 "Partenariat Entreprises Export – Centre Val-de-Loire"]
   [:h1 "Exporter l'ambition"]])

(defn header
  [args]
  [:header
   [:h2 (:heading/style args) (:heading/text args)]
   [:div (:sub-heading/style args) (:sub-heading/text args)]])

(defn offer-opportunities
  []
  [:div {:style {:flex 1
                 :padding 15}}
   [:img {:alt ""
          :src "img/offer/recherche.png"
          :style {:object-fit :contain
                  :width 128
                  :height 128}}]
   [:h3 "Recherche d'opportunités"]
   [:p
    "Une double démarche :"]
   [:ul
    [:li "Nous identifions les entreprises du Centre - Val de Loire ayant un potentiel à l'export, et leur proposons de l'exploiter."]
    [:li "Nous répondons à la demande des entreprises souhaitant initier ou développer leurs démarches export."]]])

(defn offer-network
  []
  [:div {:style {:flex 1
                 :padding 15}}
   [:img {:alt ""
          :src "img/offer/teamup.png"
          :style {:object-fit :contain
                  :width 128
                  :height 128}}]
   [:h3 "Recherche de contacts"]
   [:p
    "Nous proposons aux chefs d'entreprises intéressés d'identifier des contacts export."]
   [:p "Après signature d'un mandat de mission :"]
   [:ul
    [:li "Nous recherchons des contacts dans les régions et pays cibles."]
    [:li "Nous confirmons dans ces zones l’intérêt d'importer le produit fabriqué."]
    [:li "Nous créons le lien entre le chef d'entreprise et les contacts identifiés."]]])

(defn offer-follow-up
  []
  [:div {:style {:flex 1
                 :padding 15}}
   [:img {:alt ""
          :src "img/offer/network.png"
          :style {:object-fit :contain
                  :width 128
                  :height 128}}]
   [:h3 "Accompagnement"]
   [:p "A l'issue de la phase précédente et à la demande du chef d'entreprise :"]
   [:ul
    [:li "Nous facilitons ses démarches d'exportation,"]
    [:li "Nous facilitons en coordination avec les chambres consulaires et les organismes de développement économiques locaux, la mise en relation avec les conseils requis"]
    [:li "L'accompagnement peut aller jusqu'à l'organisation de missions dans les pays visés (exploratoire, salon, prise de contact physique etc.)"]]])

(defn offer
  []
  [:section#offer {:style {:display :flex
                           :flex-direction :row
                           :flex-wrap :wrap
                           :justify-content :center
                           :padding-left 200
                           :text-align :justify
                           :padding-right 200}}
   [:header {:style {:display :flex
                     :flex-direction :column
                     :flex-wrap :wrap
                     :align-items :center}}
    [:h2 "Nos services"]
    [:div "Trois axes d'activité pour intensifier les relations d'export des petites et moyennes entreprises de la région Centre-Val de Loire."]]
   [:div {:style {:display :flex
                  :flex-direction :row
                  :flex-wrap :wrap
                  :justify-content :space-between}}
    [offer-opportunities]
    [offer-network]
    [offer-follow-up]]])

(defn choose-us
  []
  [:section#offer
   [header {:heading/text "Pourquoi choisir PE2C?"}]

   [:div
    [:img {:alt ""
           :src "img/choose-us/action.jpg"
           :style {:object-fit :contain
                   :width 128
                   :height 128}}]
    [:div
     [:p "Pour notre action"]
     [:ul
      [:li "Pragmatique"]
      [:li "Pro-active"]
      [:li "Opérationnelle"]]]]

   [:div
    [:img {:alt ""
           :src "img/choose-us/ethos.png"
           :style {:object-fit :contain
                   :width 128
                   :height 128}}]
    [:p [:span {:style {:font-weight :bold}} "Pour notre éthique"] "fondée sur la notion de service et d'engagement"]]

   [:div
    [:img {:alt ""
           :src "img/choose-us/team.jpg"
           :style {:object-fit :contain
                   :width 128
                   :height 128}}]
    [:p [:span {:style {:font-weight :bold}} "Pour notre équipe forte"] "d'une expérience internationale et multiculturelle de terrain"]]

   [:div
    [:img {:alt ""
           :src "img/choose-us/network.png"
           :style {:object-fit :contain
                   :width 128
                   :height 128}}]
    [:p [:span {:style {:font-weight :bold}} "Pour notre réseau"] "développé au cours de 30 années d'expertise professionnelle"]]])

(defn added-value
  []
  [:section#added-value
   [:img {:alt ""
          :src "img/added-value/added-value.png"
          :style {:object-fit :contain
                  :width 128
                  :height 128}}]
   [:div
    [header {:heading/text "Notre valeur ajoutée"}]
    [:ol
     [:li "Un accompagnement personnalisé de votre entreprise vers l'export ;"]
     [:li "La rencontre de votre richesse économique et de notre expertise à l'international ;"]
     [:li "Une rémunération au succès ;"]
     [:li "Une action complémentaire aux dispositifs existants."]]]])

(defn who-are-we
  []
  [:section#who-are-we
   [header {:heading/text "Une équipe au service de votre ambition"}]

   [:div
    [:img {:alt ""
           :src "img/team/geraud-de-boisset.jpg"
           :style {:object-fit :contain
                   :width 128
                   :height 128}}]
    [:div "Géraud de Boisset"]
    [:div "Président, associé"]]

   [:div
    [:img {:alt ""
           :src "img/team/arnaud-ladrange.jpg"
           :style {:object-fit :contain
                   :width 128
                   :height 128}}]
    [:div "Arnaud Ladrange"]
    [:div "Associé"]]

   [:div
    [:img {:alt ""
           :src "img/team/pierre-niclot.jpg"
           :style {:object-fit :contain
                   :width 128
                   :height 128}}]
    [:div "Pierre Niclot"]
    [:div "Associé"]]

   [:div
    [:img {:alt ""
           :src "img/team/michel-ravet.jpg"
           :style {:object-fit :contain
                   :width 128
                   :height 128}}]
    [:div "Michel Ravet"]
    [:div "Associé"]]])

(defn get-in-touch
  []
  [:section#get-in-touch
   [header {:heading/text "Nous contacter"}]
   [:a {:href "mailto:contact@pe2c.com"} "contact@pe2c.com"]])

(defn main-panel []
  [:div
   [collapsible-sections]
   [:div#cover-image {:style {:display :flex
                              :flex-direction :row
                              :flex-wrap :wrap
                              :align-items :center
                              :justify-content :center}}
    [title]]

   [offer]
   [choose-us]
   [added-value]
   [who-are-we]
   [get-in-touch]

   (lorem-ipsum/paragraphs-el 10 [:p])

   [:div {:style {:height 350
                  :background-color :lightcoral}}
    [:div {:style {:background-color :yellow
                   :display :flex
                   :flex-direction :column
                   :flex-wrap :wrap
                   :height "100%"

                   :justify-content :flex-end
                   :align-items :flex-end
                   :align-content :flex-end

                   }}
     [:p {:style {:flex-grow 0
                  :flex-basis 0
                  :margin-bottom 0
                  :background-color :blue}} "a"]
     [:p {:style {:flex-grow 0
                  :flex-basis 0
                  :margin-bottom 0
                  :background-color :green}} "b"]
     [:p {:style {:flex-grow 1
                  :flex-basis 0
                  :margin-bottom 0
                  :background-color :violet}} "c"]]]])
