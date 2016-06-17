package com.example.administrator.mvpframe.fuc.main.entity;

import com.example.administrator.mvpframe.common.base.baseEntity.BaseEntity;

import java.util.List;

public class NewsEntity extends BaseEntity {

    private PagesEntity pages;

    public void setPages(PagesEntity pages) {
        this.pages = pages;
    }

    public PagesEntity getPages() {
        return pages;
    }

    public static class PagesEntity {
        private int limit;
        private int offset;
        private int pageNum;
        private int pageSize;
        private int totalCount;
        private int totalPages;

        private List<PageEntity> page;

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public void setPage(List<PageEntity> page) {
            this.page = page;
        }

        public int getLimit() {
            return limit;
        }

        public int getOffset() {
            return offset;
        }

        public int getPageNum() {
            return pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public List<PageEntity> getPage() {
            return page;
        }

        public static class PageEntity {
            private String content;
            private long createDate;
            private int id;
            private int messageType;
            private int readState;
            private String title;

            public void setContent(String content) {
                this.content = content;
            }

            public void setCreateDate(long createDate) {
                this.createDate = createDate;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setMessageType(int messageType) {
                this.messageType = messageType;
            }

            public void setReadState(int readState) {
                this.readState = readState;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public long getCreateDate() {
                return createDate;
            }

            public int getId() {
                return id;
            }

            public int getMessageType() {
                return messageType;
            }

            public int getReadState() {
                return readState;
            }

            public String getTitle() {
                return title;
            }
        }
    }
}
