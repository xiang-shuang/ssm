package qin.com.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;

//保证序列化json的时候,如果是null的对象,key也会消失

@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {

    private int status;   //用于表示操作是否成功，若成功则为0，若失败则为1
    private String msg;   //用于输出提示信息
    private T data;       //泛型数据可以是任何数据类型，这里一般是用于要进行输出的对象或对象集合

    /*定义了私有的构造方法*/
    private ServerResponse(int status){
        this.status = status;
    }

    /**
     * 定义私有方法
     * @param status 状态
     * @param data 泛型
     */

    private ServerResponse(int status,T data){
        this.status = status;
        this.data = data;
    }

    /**
     * 定义私有方法
     * @param status  状态
     * @param msg  提示信息
     * @param data  泛型
     */
    private ServerResponse(int status,String msg,T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 定义私有方法
     * @param status 状态
     * @param msg  提示信息
     */
    private ServerResponse(int status,String msg){
        this.status = status;
        this.msg = msg;
    }


    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    /*获取状态*/
    public int getStatus(){
        return status;
    }

    /*获取泛型信息*/
    public T getData(){
        return data;
    }

    /*获取提示信息*/
    public String getMsg(){
        return msg;
    }


    /**
     * 定义静态方法用于返回ServerResponse对象，且只对对象中的status进行
     * 初始化，这在spring mvc中进行输出转换成json时为｛"status":0｝
     * @param <T>
     * @return 返回对象
     */
    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }



    /**
     * 定义静态方法用于返回ServerResponse对象，且只对对象中的status和msg进行
     *  初始化，这在spring mvc中进行输出转换成json时为｛"status":0,"msg":msg｝
     * @param msg  提示信息
     * @param <T>  泛型
     * @return  返回对象
     */
    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }



    /**
     * 定义静态方法用于返回ServerResponse对象，且只对对象中的status和data进行
     *  初始化,设data为用户对象（设用户具有id,name,pass），在spring mvc中进行输出转换成json时为｛"status":0,
     *  "data":{"id":1,"name":"lisi","pass":"lili"}｝
     * @param data 是泛型，一般我们都把当作要输出的类的对象
     * @param <T>
     * @return
     */

    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    /**
     * 定义静态方法用于返回ServerResponse对象，且只对对象中的status和data进行
     *      *  初始化,设data为用户对象（设用户具有id,name,pass），在spring mvc中进行输出转换成json时为｛"status":0,
     *      *  "msg":"xxx成功"，"data":{"id":1,"name":"lisi","pass":"lili"}｝
     * @param msg 提示信息
     * @param data 一般为类的对象
     * @param <T> 一般为类
     * @return
     */

    public static <T> ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }



    /**
     * 定义一个静态方法用于返回ServerResponse对象，且只对象中的status和msg进行初始化，在
     * spring mvc输出时为｛“status":1,"msg":xxxxx｝
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }


    /*同上是错误提示信息*/
    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    /*同上是错误提示信息*/
    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new ServerResponse<T>(errorCode,errorMessage);
    }

}