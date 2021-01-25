<template>
  <div id="wall">
    <h1>Стеночка</h1>
    <div class="mt-4">
      <router-link to="/">
        <button type="button" class="btn btn-primary">Home</button>
      </router-link>
      <button v-if="this.$cookies.get('user_id') != null" v-on:click="reloginUser()" class="btn btn-primary"
              id="exit-button">Выход
      </button>
    </div>
    <div class="mt-2">
      <router-link to="/users">
        <button type="button" class="btn btn-primary">Пользователи</button>
      </router-link>
    </div>
    <div class="mt-4">
      <PostList/>
    </div>
  </div>
</template>

<script>
import PostList from "@/components/PostsList";

export default {
  components: {PostList},
  methods: {
    reloginUser() {
      this.$cookies.remove("user_id");
      window.location = "/";
    }
  }
}
</script>