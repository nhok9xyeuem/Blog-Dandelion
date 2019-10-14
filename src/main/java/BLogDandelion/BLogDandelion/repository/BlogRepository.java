package BLogDandelion.BLogDandelion.repository;

import BLogDandelion.BLogDandelion.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends PagingAndSortingRepository<Blog,Long> {

}
