package io.oken1.modules.mug.entity;

public class BiliUploaderEntity {

    public UserData data;

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    public class UserData {
        public String archive_count;

        public String getArchiveCount() {
            return archive_count;
        }

        public void setArchiveCount(String archive_count) {
            this.archive_count = archive_count;
        }

        public Card card;

        public Card getCard() {
            return card;
        }

        public void setCard(Card card) {
            this.card = card;
        }


        public class Card {
            public Long getMid() {
                return mid;
            }

            public void setMid(Long mid) {
                this.mid = mid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getFace() {
                return face;
            }

            public void setFace(String face) {
                this.face = face;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public String getFriend() {
                return friend;
            }

            public void setFriend(String friend) {
                this.friend = friend;
            }

            public String getAttention() {
                return attention;
            }

            public void setAttention(String attention) {
                this.attention = attention;
            }

            public Long mid;
            public String name;
            public String sex;
            public String face;
            public String fans;
            public String friend;
            public String attention;

            public String userToString() {
                return this.mid + "	" + this.name + "	" + this.fans + "	" + this.attention;
            }
        }
    }
}
