package pers.eddievim.dp.behavioral.cor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eddieVim
 * @微信公众号 埃迪的Code日记 / PositiveEddie
 * @blog https://blog.csdn.net/weixin_44129784
 * @create 2020/8/25 6:06 下午
 */
public interface Filter {
    public void doFilter(Request request, Response response, FilterChain filterChain);
}

interface FilterChain {
    public void doFilter(Request request, Response response);

    public FilterChain add(Filter filter);
}

class FilterImpl implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.str += "xx";
        filterChain.doFilter(request, response);
        response.str += "zz";
    }
}

class FilterChainImpl implements FilterChain {
    private List<Filter> list = new ArrayList<>();
    private int count = 0;

    @Override
    public void doFilter(Request request, Response response) {
        if (count == list.size()) {
            return;
        }
        Filter filter = list.get(count++);
        filter.doFilter(request, response, this);
        // count--;
    }

    @Override
    public FilterChain add(Filter filter) {
        list.add(filter);
        return this;
    }
}


class Request {
    String str = "";
}

class Response {
    String str = "";
}

class Test {
    public static void main(String[] args) {
        FilterChainImpl filterChain = new FilterChainImpl();
        filterChain.add(new FilterImpl())
                .add(new FilterImpl())
                .add(new Filter() {
                    @Override
                    public void doFilter(Request request, Response response, FilterChain filterChain) {
                        request.str += "request";
                        response.str += "response";
                    }
                });

        Request request = new Request();
        Response response = new Response();

        filterChain.doFilter(request, response);

        System.out.println(request.str);
        System.out.println(response.str);
    }
}

