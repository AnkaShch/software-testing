<template>
  <div>
    <router-link :to="{ name: 'user', params: { id: user.id}}">{{ user.name }}</router-link>
  </div>
</template>

<script>
export default {
  name: "UserItem",
  props: {
    user: {
      type: Object,
      required: true
    },
    index: Number
  }
}
</script>

<style scoped>

</style>