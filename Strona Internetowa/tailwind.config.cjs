/** @type {import('tailwindcss').Config}*/
const config = {
  content: ["./src/**/*.{html,js,svelte,ts}"],

  theme: {
    extend: {
      height: {
        'full105': '105vh'
      },
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
