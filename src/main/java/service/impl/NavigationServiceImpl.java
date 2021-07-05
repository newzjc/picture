package service.impl;

import dao.Impl.NavigationDaoImpl;
import pogo.Navigation;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;
import service.NavigationService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NavigationServiceImpl implements NavigationService {
    private NavigationDaoImpl dao = new NavigationDaoImpl();

    @Override
    public List<Navigation> findAll() {
        Jedis jedis = new Jedis();
        //查询值(cname)
        //Set<String> navigations = jedis.zrange("navigation", 0, -1);

        //查询sortedset中的分数(cid)和值(cname)
        Set<Tuple> Navigations = jedis.zrangeWithScores("Navigation", 0, -1);
        /*for (Tuple tuple : navigations) {
            System.out.println(tuple.getScore()+"=="+tuple.getElement());
        }*/
        List<Navigation> ns = null;
        //若缓存中没有数据,就从数据库中查询并保存到缓存中,否则就将从缓存中的数据(set)转换为需要返回的数据(List)
        if (Navigations == null || Navigations.size() == 0) {
            ns = dao.findAll();

            for (Navigation s : ns) {
                jedis.zadd("Navigation", s.getNid(), s.getContent());
            }

           /* for (int i = 0; i < cs.size(); i++) {
                jedis.zadd("Category", cs.get(i).getCid(), cs.get(i).getCname());
            }*/
        } else {
            ns = new ArrayList<Navigation>();

            /*for (String set_category : categorys) {
                Category category = new Category();
                category.setCname(set_category);
                cs.add(category);
            }*/

            for (Tuple tuple : Navigations) {
                Navigation navigation = new Navigation();
                //获取分母
                navigation.setNid((int)tuple.getScore());
                //获取值
                navigation.setContent(tuple.getElement());
                ns.add(navigation);
            }
        }
        return ns;

    }
}
