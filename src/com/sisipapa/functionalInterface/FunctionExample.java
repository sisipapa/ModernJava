package com.sisipapa.functionalInterface;

import java.util.function.Function;

public class FunctionExample {
    // Function<T, R>
    // 역할: 입력값을 받아 변환하여 반환.
    // 예시: 사용자 데이터 변환 (DTO → Entity)
    public static void main(String[] args) {
        Function<UserDTO, UserEntity> dtoToEntity = userDTO -> new UserEntity(userDTO.getId(),
                userDTO.getName());

        UserDTO userDTO = new UserDTO(1, "김경훈");
        UserEntity userEntity = dtoToEntity.apply(userDTO);

        System.out.println("User Entity: " + userEntity);
    }

    static class UserDTO {

        private final int id;
        private final String name;

        public UserDTO(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    static class UserEntity {

        private final int id;
        private final String name;

        public UserEntity(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "UserEntity{id=" + id + ", name='" + name + "'}";
        }
    }
}
