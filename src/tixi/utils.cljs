(ns tixi.utils)

(enable-console-print!)

(defn p [value]
  "Prints the value, and then returns it"
  (*print-fn* (pr-str value))
  value)

(defn seq-contains? [coll target]
  (some #(= target %) coll))

(defn benchmark
  "Prints the execution time for the given function. Accepts optional string, which will be used as a description"
  ([f] (benchmark nil f))
  ([msg f]
  (let [start (.now js/Date)
        result (f)]
    (p (str (when msg (str msg ": ")) (- (.now js/Date) start) "ms"))
    result)))