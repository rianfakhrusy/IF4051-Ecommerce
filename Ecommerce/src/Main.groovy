/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Husni
 */

Product product = new Product(name: "Repsol Honda", price : 1000, stock : 1 );
Wallet w = new Wallet(amount: 0);
User u = new User(wallet : w, name : "Rossi");

println u
refund(u,product,50)
println u

void refund(User u, Product product, int percent){
    u.wallet.addAmount(product.price*percent/ 100);
}