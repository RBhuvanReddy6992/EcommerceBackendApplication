package com.ecommerce.Cart_Service.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.Cart_Service.FeignClient.ProductFeignClient;
import com.ecommerce.Cart_Service.Model.Cart;
import com.ecommerce.Cart_Service.Model.ProductDTO;
import com.ecommerce.Cart_Service.Repository.CartRepository;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductFeignClient productFeign;

    
    public CartService(CartRepository cartRepository,
                       ProductFeignClient productFeign) {
        this.cartRepository = cartRepository;
        this.productFeign = productFeign;
    }

    // ADD TO CART
    public Cart addToCart(Cart cart) {

       
        ProductDTO product = productFeign.getProduct(cart.getProductid());

        if (product == null) {
            throw new RuntimeException("Product does not exist");
        }

        if (product.getQuantity() < cart.getQuantity()) {
            throw new RuntimeException("Not enough stock available");
        }

        Cart existingCart = cartRepository
                .findByUseridAndProductid(cart.getUserid(), cart.getProductid());

        if (existingCart != null) {
            existingCart.setQuantity(
                existingCart.getQuantity() + cart.getQuantity()
            );
            return cartRepository.save(existingCart);
        }

        return cartRepository.save(cart);
    }

    // UPDATE QUANTITY
    public Cart updateQuantity(Integer cartId, Integer quantity) {

        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));

        cart.setQuantity(quantity);
        return cartRepository.save(cart);
    }

    // REMOVE ITEM
    public void removeFromCart(Integer cartId) {
        cartRepository.deleteById(cartId);
    }

    // CLEAR CART
    public void clearCart(Integer userId) {
        List<Cart> carts = cartRepository.findByUserid(userId);
        cartRepository.deleteAll(carts);
    }
}