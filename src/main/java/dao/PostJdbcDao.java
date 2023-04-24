package dao;

import model.Post;

import java.util.List;

public class PostJdbcDao implements PostDao{

    @Override
    public boolean create(Post entity) {
        return false;
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Post findById(Long aLong) {
        return null;
    }

    @Override
    public void update(Post entity) {

    }

    @Override
    public void delete(Post entity) {

    }
}
