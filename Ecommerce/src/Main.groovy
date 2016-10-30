/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Husni
 */

//Inisialisasi
Product product = new Product(name: "Repsol Honda", price : 1000, stock : 10 )
def order = new Order(id = 332)
order.items << new Tuple(product,1)
def w = new Wallet(amount: 0)
def user1 = new User(wallet : w, name : "Rossi")
user1.orders << order

//print
println user1
refund_transaction user1 no 332 cut_percentage 50 //Pemanggilan DSL Groovy 1
println user1


//DSL 1: Refund
//Memberikan uang ke user sesuai dengan persentase yang udah ditentukan dari harga barang yang udah diorder
def refund_transaction(u) {
  [no: { id ->
    [cut_percentage: { percent -> 
        def idx = u.orders.findIndexOf{it.id == id}
        u.orders[idx].items.each {
            u.wallet.topUp(it.get(1)*it.get(0).price*percent/100)
        }
        u.orders.remove(idx)
    }]
  }]
}