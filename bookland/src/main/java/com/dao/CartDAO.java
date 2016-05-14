package com.dao;

import java.io.IOException;
import java.util.List;

import com.model.*;

public interface CartDAO {
	Cart getCartById(int cartId);

    Cart validate(int cartId) throws IOException;

    void update(Cart cart);
	
}
