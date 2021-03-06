package com.github.edgar615.shaddingsphere.entity;

import com.github.edgar615.util.db.Persistent;
import com.github.edgar615.util.db.PrimaryKey;
import com.github.edgar615.util.db.VirtualKey;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* This class is generated by Jdbc code generator.
*
* Table : user_password
* remarks: 
*
* @author Jdbc Code Generator Date 2020-12-30
*/
public class UserPassword implements Persistent<Long> {

    private static final long serialVersionUID = 1L;
    
    /**
    * Column : user_password_id
    * remarks: id
    * default: 
    * isNullable: false
    * isAutoInc: false
    * isPrimary: true
    * type: -5
    * size: 19
    */
    @PrimaryKey
    private Long userPasswordId;

    /**
    * Column : user_id
    * remarks: id
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: -5
    * size: 19
    */
    private Long userId;
    
    /**
    * Column : password
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 12
    * size: 64
    */
    private String password;
    
    /**
    * Column : created_on
    * remarks: db
    * default: CURRENT_TIMESTAMP
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 93
    * size: 26
    */
    @VirtualKey
    private Date createdOn;

    /**
    * Column : updated_on
    * remarks: db
    * default: CURRENT_TIMESTAMP
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 93
    * size: 26
    */
    @VirtualKey
    private Date updatedOn;

    public Long getUserPasswordId() {
        return userPasswordId;
    }

    public void setUserPasswordId(Long userPasswordId) {
        this.userPasswordId = userPasswordId;
    }
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    
    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper("UserPassword")
            .add("userPasswordId",  userPasswordId)
            .add("userId",  userId)
            .add("password",  password)
            .add("createdOn",  createdOn)
            .add("updatedOn",  updatedOn)
           .toString();
    }

    @Override
    public List<String> fields() {
      return Lists.newArrayList("userPasswordId",
						"userId",
						"password",
						"createdOn",
						"updatedOn");
    }
    
    public List<String> virtualFields() {
        return Lists.newArrayList("createdOn",
						"updatedOn");
    }
    
    @Override
    public String primaryField() {
        return "userPasswordId";
    }

    @Override
    public Long id () {
    return userPasswordId;
    }

    @Override
    public void setId(Long id) {
        this.userPasswordId = id;
    }

    @Override
    public void setGeneratedKey(Number key) {
    
        this.userPasswordId = key.longValue();
    
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("userPasswordId",  userPasswordId);
        map.put("userId",  userId);
        map.put("password",  password);
        map.put("createdOn",  createdOn);
        map.put("updatedOn",  updatedOn);
        return map;
    }

    @Override
    public void fromMap(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        if (map.get("userPasswordId") instanceof Long) {
            this.userPasswordId = (Long) map.get("userPasswordId");
        }
        if (map.get("userId") instanceof Long) {
            this.userId = (Long) map.get("userId");
        }
        if (map.get("password") instanceof String) {
            this.password = (String) map.get("password");
        }
        if (map.get("createdOn") instanceof Date) {
            this.createdOn = (Date) map.get("createdOn");
        }
        if (map.get("updatedOn") instanceof Date) {
            this.updatedOn = (Date) map.get("updatedOn");
        }
        
    }

   /* START Do not remove/edit this line. CodeGenerator will preserve any code between start and end tags.*/
	/* END Do not remove/edit this line. CodeGenerator will preserve any code between start and end tags.*/
}