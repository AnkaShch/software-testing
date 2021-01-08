<template>
  <div id="home">
    <img alt="Vue logo" src="./../assets/vk.png">
    <h1>Дуров верни стеночку!</h1>
    <div class="mt-4">
      <router-link to="/users">
        <button type="button" class="btn btn-primary">Пользователи</button>
      </router-link>
    </div>
    <div class="mt-2">
    <router-link to="/registration">
      <button type="button" class="btn btn-primary">Регистрация</button>
    </router-link>
    </div>
    <div class="mt-2">
      <router-link to="/login">
        <button type="button" class="btn btn-primary">Вход</button>
      </router-link>
      <button v-on:click="reloginUser" class="btn btn-primary">Выход</button>
    </div>
  </div>
</template>

<script>

export default {
  name: "Home",
  methods: {
    reloginUser() {
      console.log(this.$cookies.get("user_id"))
      this.$cookies.remove("user_id")
    }
  }
}
</script>

<style scoped>

#home {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

</style>