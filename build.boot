(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.11"   :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.7"    :scope "test"]
                  [cljsjs/jquery-ui   "1.11.3-1" :scope "provided"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def jquery-ui-datepicker-pt-BR-version "0.0.1")
(def +version+ (str jquery-ui-datepicker-pt-BR-version "-0"))
(bootlaces! +version+)

(task-options!
  pom {:project     'cljsjs/jquery-ui-datepicker-pt-BR
       :version     +version+
       :description "Translation for jquery-ui datepicker"
       :url         "https://github.com/jquery/jquery-ui/tree/master/ui/i18n"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (sift :include #{#"^cljsjs"})
    (deps-cljs
      :name "cljsjs.jquery-ui-datepicker-pt-BR"
      :requires ["cljsjs.jquery-ui"]
      :no-externs true)))
