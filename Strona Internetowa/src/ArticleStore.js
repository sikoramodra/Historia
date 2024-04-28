// ArticleStore.js

import { writable } from 'svelte/store';

// Tworzymy pusty sklep danych z artykułami
const articles = writable([]);

// Dodajemy przykładowe artykuły
articles.set([
    { slug: 'jogurt', title: 'Yogurt', content: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.' },
    { slug: 'czekolada', title: 'Chocolate', content: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.' },
    { slug: 'inny-artykul', title: 'Another Article', content: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.' }
]);

// Eksportujemy funkcję, która pozwoli nam subskrybować zmiany w artykułach
export const subscribeToArticles = articles.subscribe;
export { articles };