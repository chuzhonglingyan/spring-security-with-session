package com.yuntian.jwt.config.redis;

import org.springframework.data.redis.core.*;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @Auther: yuntian
 * @Date: 2019/8/17 0017 22:17
 * @Description:
 */
public class RedisManage {

    /**
     * 最大缓存时间  一个月
     */
    private static int MAX_CACHE_TIME = 86400 * 30;

    @Resource
    private RedisTemplate redisTemplate;

    private long getExTime(long time) {
        if (time <= 0) {
            time = 1;
        }
        if (time > MAX_CACHE_TIME) {
            time = MAX_CACHE_TIME;
        }
        return time;
    }

    /* ================================String=================================  */


    public <V> void set(String key, V v) {
        set(key, v, MAX_CACHE_TIME);
    }

    public <V> void set(String key, V v, long time) {
        getValueOperations().set(key, v, getExTime(time), TimeUnit.SECONDS);
    }

    public <V> V getValue(String key) {
        ValueOperations<String, V> valueOperations = getValueOperations();
        return valueOperations.get(key);
    }


    private <V> ValueOperations<String, V> getValueOperations() {
        return redisTemplate.opsForValue();
    }


    /* ================================list  一个链表，链表上的每个节点都包含了一个字符串 ================================
       ================================从链表的两端推入或者弹出元素；根据偏移量对链表进行修剪(trim)；读取单个或者多个元素；根据值来查找或者移除元素=================================  */

    /**
     * 元素入集合
     *
     * @param key
     * @param v
     * @param time
     * @param <V>
     */
    public <V> void push(String key, V v, long time) {
        List<V> list = new ArrayList<>();
        list.add(v);
        push(key, list, getExTime(time));
    }

    /**
     * 元素入集合
     *
     * @param key
     * @param v
     * @param time
     * @param <V>
     */
    public <V> void push(String key, List<V> v, long time) {
        getListOperations().rightPushAll(key, v, getExTime(time));
    }

    /**
     * 元素出栈
     *
     * @param key
     * @param <V>
     */
    public <V> void pop(String key) {
        getListOperations().rightPop(key);
    }

    /**
     * 元素出队列
     *
     * @param key
     * @param <V>
     */
    public <V> void peek(String key) {
        getListOperations().leftPop(key);
    }


    /**
     * List（列表） Redis的List是链表型的数据结构，可以使用LPUSH/RPUSH/LPOP/RPOP等命令在List的两端执行插入元素和弹出元素的操作
     * 两端执行 时间复杂度O(1)
     * 特定index上插入和读取元素的功能，但其时间复杂度较高O(N)
     */
    private <V> ListOperations<String, V> getListOperations() {
        return redisTemplate.opsForList();
    }

    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /* ================================Map=================================  */

    private <HK, HV> HashOperations<String, HK, HV> getOpsForHash() {
        return redisTemplate.opsForHash();
    }


    /**
     * HashGet
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return 值
     */
    public Object hGet(String key, String item) {
        return getOpsForHash().get(key, item);
    }

    /**
     * 获取hashKey对应的所有键值
     *
     * @param key 键
     * @return 对应的多个键值
     */
    public Map<Object, Object> hmGet(String key) {
        return getOpsForHash().entries(key);
    }

    /**
     * HashSet
     *
     * @param key 键
     * @param map 对应多个键值
     * @return true 成功 false 失败
     */
    public boolean hmSet(String key, Map<String, Object> map) {
        try {
            getOpsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * HashSet 并设置时间
     *
     * @param key  键
     * @param map  对应多个键值
     * @param time 时间(秒)
     * @return true成功 false失败
     */
    public boolean hmSet(String key, Map<String, Object> map, long time) {
        try {
            getOpsForHash().putAll(key, map);
            redisTemplate.expire(key, getExTime(time), TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @return true 成功 false失败
     */
    public boolean hSet(String key, String item, Object value) {
        try {
            getOpsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @param time  时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return true 成功 false失败
     */
    public boolean hSet(String key, String item, Object value, long time) {
        try {
            getOpsForHash().put(key, item, value);
            redisTemplate.expire(key, getExTime(time), TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除hash表中的值
     *
     * @param key  键 不能为null
     * @param item 项 可以使多个 不能为null
     */
    public void hDel(String key, Object... item) {
        getOpsForHash().delete(key, item);
    }

    /**
     * 判断hash表中是否有该项的值
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return true 存在 false不存在
     */
    public boolean hHasKey(String key, String item) {
        return getOpsForHash().hasKey(key, item);
    }

    /**
     * hash递增 如果不存在,就会创建一个 并把新增后的值返回
     *
     * @param key  键
     * @param item 项
     * @param by   要增加几(大于0)
     * @return
     */
    public double hIncr(String key, String item, double by) {
        return getOpsForHash().increment(key, item, by);
    }

    /**
     * hash递减
     *
     * @param key  键
     * @param item 项
     * @param by   要减少记(小于0)
     * @return
     */
    public double hDecr(String key, String item, double by) {
        return getOpsForHash().increment(key, item, -by);
    }

    /* ============================set 包含字符串的无序收集器(unorderedcollection)，并且被包含的每个字符串都是独一无二的、各不相同  ============================
       ============================添加、获取、移除单个元素；检查一个元素是否存在于某个集合中；计算交集、并集、差集；从集合里卖弄随机获取元素============================= */

    private <V> SetOperations<String, V> getSetOperations() {
        return redisTemplate.opsForSet();
    }


    /**
     * 根据key获取Set中的所有值
     *
     * @param key 键
     * @return
     */
    public Set<Object> sGet(String key) {
        try {
            return getSetOperations().members(key);
        } catch (Exception e) {
            e.printStackTrace();
            return new HashSet<>();
        }
    }

    /**
     * 将数据放入set缓存
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public <V> long sSet(String key, V... values) {
        try {
            Long count = getSetOperations().add(key, values);
            return count == null ? 0 : count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    /**
     * 获取set缓存的长度
     *
     * @param key 键
     * @return
     */
    public long sGetSetSize(String key) {
        try {
            Long count = getSetOperations().size(key);
            return count == null ? 0 : count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 移除值为value的
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 移除的个数
     */
    public <V> long setRemove(String key, V... values) {
        try {
            Long count = getSetOperations().remove(key, (Object) values);
            return count == null ? 0 : count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


}
