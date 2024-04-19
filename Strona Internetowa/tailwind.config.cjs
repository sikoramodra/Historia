/** @type {import('tailwindcss').Config}*/
const config = {
  content: ["./src/**/*.{html,js,svelte,ts}"],

  theme: {
    extend: {
      colors: {
        'DomCzerw': '#ed1915',
      },
      fontFamily: {
        'body': ['"Open Sans"'],
      }
      
    },
  },

  plugins: [],
};

module.exports = config;
