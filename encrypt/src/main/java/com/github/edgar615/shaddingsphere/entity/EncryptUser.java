package com.github.edgar615.shaddingsphere.entity;

import com.github.edgar615.util.db.Persistent;
import com.github.edgar615.util.db.PrimaryKey;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
* This class is generated by Jdbc code generator.
*
* Table : user
* remarks: 
*
* @author Jdbc Code Generator Date 2020-12-30
*/
public class EncryptUser implements Persistent<Long> {

    private static final long serialVersionUID = 1L;
    
    /**
    * Column : user_id
    * remarks: id
    * default: 
    * isNullable: false
    * isAutoInc: false
    * isPrimary: true
    * type: -5
    * size: 19
    */
    @PrimaryKey
    private Long userId;

    /**
    * Column : username
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 12
    * size: 60
    */
    private String username;
    
    /**
    * Column : nickname
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 12
    * size: 16
    */
    private String password;
    

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper("User")
            .add("userId",  userId)
            .add("username",  username)
            .add("password",  password)
           .toString();
    }

    @Override
    public List<String> fields() {
      return Lists.newArrayList("userId",
						"username",
						"password");
    }
    
    @Override
    public String primaryField() {
        return "userId";
    }

    @Override
    public Long id () {
    return userId;
    }

    @Override
    public void setId(Long id) {
        this.userId = id;
    }

    @Override
    public void setGeneratedKey(Number key) {
    
        this.userId = key.longValue();
    
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("userId",  userId);
        map.put("username",  username);
        map.put("password",  password);
        return map;
    }

    @Override
    public void fromMap(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        if (map.get("userId") instanceof Long) {
            this.userId = (Long) map.get("userId");
        }
        if (map.get("username") instanceof String) {
            this.username = (String) map.get("username");
        }
        if (map.get("password") instanceof String) {
            this.password = (String) map.get("password");
        }
    }

   /* START Do not remove/edit this line. CodeGenerator will preserve any code between start and end tags.*/
	/* END Do not remove/edit this line. CodeGenerator will preserve any code between start and end tags.*/
}