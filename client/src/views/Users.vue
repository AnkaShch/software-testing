<template>
  <div>
    <h1>Users</h1>
    <UsersList
        v-bind:users="users"
    />
    <div class="mt-4">
      <router-link to="/">
        <button type="button" class="btn btn-primary">Home</button>
      </router-link>
    </div>
  </div>
</template>

<script>
import UsersList from "@/components/UsersList";
import axios from 'axios';

export default {
  name: "Users",
  components: {UsersList},
  data() {
    return {
      users: [{id: 100500, name: 'Anya100500', password: '100500'}, {id: 21111, name: 'Kate', password: '123123'}]
    }
  },
  mounted() {
    try {
      axios
          .get('http://localhost:8080/api/getListOfUsers')
          .then(response => {
            response.data.forEach(data => {
              let user = {id: data.id, name: data.name, password: data.password}
              this.users.push(user)
              // console.log(this.users)
            })
          });
    } catch {
      this.users = []
    }
  }

}
</script>

<style scoped>

</style>