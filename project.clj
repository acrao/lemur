(defproject lemur "0.9.0-SNAPSHOT"

  :description "Lemur is a tool to launch hadoop jobs locally or on EMR
                based on a configuration file, referred to as a jobdef."

  :jvm-opts ["-Dlog4j.configuration=file:resources/log4j.properties"]

  :source-path "src/main/clj"
  :test-path "src/test/clj"

  :dependencies [[org.clojure/clojure "1.2.1"]
                 [org.clojure/tools.logging "0.2.3"]
                 [org.clojure/data.json "0.1.2"]

                 ; aws-java-sdk-1.3.3 does not specify the correct httpclient, so we do it explicitly
                 [org.apache.httpcomponents/httpclient "4.1.1"]
                 [com.amazonaws/aws-java-sdk "1.3.3"
                  :exclusions [javax.mail/mail org.apache.httpcomponents/httpclient]]

                 ; TODO these two are only to support hipchat-- isolate that functionality, so these libs can be optional
                 [clj-http "0.1.3"]
                 [org.yaml/snakeyaml "1.7"]

                 ; TODO we should be able to consolidate on one or the other of these:
                 [com.google.guava/guava "10.0.1"]
                 [commons-io/commons-io "1.4"]

                 ; Other
                 ]

  :dev-dependencies [[robert/hooke "1.1.0"] ;for leiningen test-selectors
                     [org.clojure/tools.trace "0.7.1"]
                     [midje "1.3.1"]
                     [lein-midje "1.0.8"]
                     [clojure-source "1.2.0"]]

  :test-selectors {:default (fn [v] (not (or (:integration v) (:manual v))))
                   :integration :integration
                   :manual :manual
                   :all (fn [v] (not (:manual v)))}

  ;:main lemur.core
  )