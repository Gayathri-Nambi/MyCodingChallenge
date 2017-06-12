
package com.mytask.java.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "registerUserResponse", namespace = "http://java.mytask.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registerUserResponse", namespace = "http://java.mytask.com/")
public class RegisterUserResponse {

    @XmlElement(name = "return", namespace = "")
    private com.mytask.java.UserDTO _return;

    /**
     * 
     * @return
     *     returns UserDTO
     */
    public com.mytask.java.UserDTO getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.mytask.java.UserDTO _return) {
        this._return = _return;
    }

}
