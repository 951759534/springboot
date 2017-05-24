package org.news.router.beans;


import lombok.ToString;

/**
 * Created by K550jk on 2017/4/8.
 */
@ToString
public class PageList {


    public int getPage() {
        int pageNum =(int)Math.ceil((double)this.sum/(double)this.size);
        if(this.page>=this.num&&this.page>pageNum){
            this.page = pageNum;
        }
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    private int page;    //当前页数
    private int size;    //每页大小

    public PageList(int page, int size, int sum, int num) {
        this.page = page;
        this.size = size;
        this.sum = sum;
        this.num = num;
    }

    public int getPageNum() {
        pageNum =(int)Math.ceil((double)this.sum/(double)this.size);
        return pageNum;
    }
    private int pageNum;
    private int sum;     //总数
    private int num;     //页面显示的页数
    public int[] pagelist(){

        int pageNum =(int)Math.ceil((double)this.sum/(double)this.size);
        int NowPages = 0;
        this.num = pageNum>5?5:pageNum;
        int[] pageli = new int[this.num];
        if(this.page>=this.num){  //判断页数是否大于等于要显示的页数
            if(this.page>=pageNum){  //判断页数是否大于等于当前页数
                NowPages = pageNum;
                if(this.page>pageNum){   //判断页数是否超出当前页数
                    this.page = pageNum;
                }
            }else{
                NowPages =this.page+1;
            }
        }
        int count = 0;
        if(pageNum==NowPages&&NowPages>this.num) {   //判断是否有下一个page //当前page是大于要显示的数
            for(int i=pageNum-this.num+1;i<=pageNum;i++){
                System.out.println(i);
                pageli[count] = i;
                count++;
            }
        }else{
            for (int i = (NowPages >= pageli.length ? NowPages - pageli.length + 1 : 1); i <= (NowPages >= pageli.length ? NowPages : pageli.length); i++) {
                pageli[count] = i;
                count++;
            }
        }
        return pageli;
    };
}
