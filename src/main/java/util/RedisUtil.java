package util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {

    //redis服务器IP
    private static String  ADDR       = "127.0.0.1";
    //redis端口号
    private static int     PORT       = 6379;

    //访问密码
    private static String    PWD      = "Passw0rd";

    //最大可用连接数，默认值为8
    private static int      MAX_TOTAL = 512 ;

    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE = 50;

    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。
    private static int MAX_WAIT = 10000;

    private static int TIMEOUT = 10000;

    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;

    private static JedisPool jedisPool = null;

    static {
        try{
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_TOTAL);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
//            使用密码登陆的Redis
//            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, PWD);
            //Redis未设置密码
            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public synchronized static Jedis getJedis(){
        try{
            if(jedisPool != null){
                Jedis jedis = jedisPool.getResource();
                return jedis;
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
