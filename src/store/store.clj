(ns store.store
  (:require [store.db]))

(println (store.db/order-total))

; Calcula o preço total de um item existente no pedido
(defn total-item-value
  [[_ values]]
  (* (get values :amount 0) (get values :price 0)))

; Calcula o valor total de um pedido
(defn total-order
  [item]
  (->> item
       (map total-item-value)
       (reduce + )))

; Calcula o valor total de todos os pedidos feitos pelo usuário
(defn total-orders
  [items]
  (->> items
       (map :items)
       (map total-order)
       (reduce +)))

; Monta o map informando o usuário e seu respectivo valor total gasto
(defn total-by-user
  [[user items]]
  { :user user,
    :total-price (total-orders items)})

(->> (store.db/order-total)
     (group-by :user)
     (map total-by-user)
     println)
