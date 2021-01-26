package com.oldVK.main.dao;

import com.oldVK.main.models.Post;
import com.oldVK.main.models.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PostJdbcDao extends JdbcDaoSupport implements PostDao {
    public PostJdbcDao(DataSource dataSource) {
        super();
        setDataSource(dataSource);
        String initSqlPosts = "CREATE TABLE IF NOT EXISTS POST " +
                "(OWNER_ID INT not null, " +
                "AUTHOR_ID INT not null, " +
                "MESSAGE TEXT not null);";
        getJdbcTemplate().update(initSqlPosts);
    }

    @Override
    public List<Post> getPosts(int owner_id) {
        String sql = "SELECT U.name, P.message " +
                "FROM POST as P, User as U " +
                "WHERE P.owner_id = " + owner_id +
                " And P.author_id = U.id;";
        List<Post> posts = getPostsBySql(sql);
        return posts;
    }

    private List<Post> getPostsBySql(String sql) {
//        System.out.println("!!!!SQL: " + sql);
        List<Post> posts = new ArrayList<Post>();
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            Post post = new Post((String)row.get("name"), (String) row.get("message"));
//            post.print();
            posts.add(post);
        }
        return posts;
    }
}
