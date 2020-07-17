(ns store.db)

(def order-1
  { :user 1,
    :items { :bag { :id :bag, :amount 1, :price 100 },
             :t-shirt { :id :t-shirt, :amount 5, :price 50 }}})

(def order-2
  { :user 2,
   :items { :pants { :id :pants, :amount 2, :price 90 },
            :t-shirt { :id :t-shirt, :amount 2, :price 50 },
            :sock { :id :sock, :amount 5, :price 10 }}})

(def order-3
  { :user 3,
   :items { :sock { :id :sock, :amount 2, :price 10 }}})

(def order-4
  { :user 3,
   :items { :pants { :id :pants, :amount 2, :price 90 }}})

(defn order-total []
  [order-1 order-2 order-3 order-4])