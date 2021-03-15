package com.ineffable.shopfast.Repository;

import com.ineffable.shopfast.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Long> {
}
