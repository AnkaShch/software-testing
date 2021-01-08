<template>
  <div>
    <ul>
      <UserItem
          v-for="(user,i) of users"
          v-bind:user="user"
          v-bind:key="user"
          v-bind:index="i"
      />
    </ul>
  </div>
</template>

<script>
import UserItem from "@/components/UserItem";

export default {
  name: "UsersList",
  props: ['users'],
  components: {
    UserItem
  }
}
</script>

<style scoped>
ul {
  list-style: none;
  margin: 0;
  padding: 0;
}
</style>