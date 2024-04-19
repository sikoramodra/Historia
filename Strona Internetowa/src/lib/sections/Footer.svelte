<script>
	import { mainColorBorder, mainColorText } from "../../stores/ColorStore";
	
		
	mainColorText.set("text-white");
	mainColorBorder.set("border-white");


</script>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Completed - NewsFlash | Home</title>
	<!-- Favicon -->
	<link rel="icon" type="image/png" sizes="32x32" href="./assets/images/favicon.png">
	<!-- Remix icons -->
	<link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
	<!-- Swiper.js styles -->
	<link rel="stylesheet" href="./assets/css/swiper-bundle.min.css"/>
	<!-- Custom styles -->
	<link rel="stylesheet" href="./assets/css/main.css">
</head>
<body>
<footer class="footer section">
	
	<div class="footer-container container d-grid">
		
		<div class="company-data">
			<a href="./index.html">
				<h2 class="logo">NewsFlash</h2>
			</a>
			<p class="company-description">Lorem ipsum dolor sit amet consectetur adipisicing elit. Facere, iure. Harum, animi dolores, nam, ad magni expedita.</p>
			
			<ul class="list social-media">
				<li class="list-item">
					<a href="https://www.instagram.com/jestesmybypamietac/" target="_blank" class="list-link"><i class="ri-instagram-line"></i></a>
				</li>
				<li class="list-item">
					<a href="https://www.facebook.com/jestesmybypamietac2023?locale=pl_PL" target="_blank" class="list-link"><i class="ri-facebook-circle-line"></i></a>
				</li>
				
			</ul>

			<span class="copyright-notice">&copy;2021 NewsFlash. All rights reserved.</span>
		</div>

		<div>
			<h6 class="title footer-title">Categories</h6>
			
			<ul class="footer-list list">
				<li class="list-item">
					<a href="#" class="list-link">Travel</a>
				</li>
				<li class="list-item">
					<a href="#" class="list-link">Food</a>
				</li>
				<li class="list-item">
					<a href="#" class="list-link">Technology</a>
				</li>
				
			</ul>

		</div>

		<div>
			<h6 class="title footer-title">Useful links</h6>
			
			<ul class="footer-list list">
				<li class="list-item">
					<a href="#" class="list-link">Home</a>
				</li>
				<li class="list-item">
					<a href="#" class="list-link">Elements</a>
				</li>
				<li class="list-item">
					<a href="#" class="list-link">Tags</a>
				</li>
				<li class="list-item">
					<a href="#" class="list-link">Authors</a>
				</li>
				<li class="list-item">
					<a href="#" class="list-link">Membership</a>
				</li>
			</ul>

		</div>

		<div>
			<h6 class="title footer-title">Company</h6>
			
			<ul class="footer-list list">
				<li class="list-item">
					<a href="#" class="list-link">Contact us</a>
				</li>
				<li class="list-item">
					<a href="#" class="list-link">F.A.Q</a>
				</li>
				<li class="list-item">
					<a href="#" class="list-link">Careers</a>
				</li>
				<li class="list-item">
					<a href="#" class="list-link">Authors</a>
				</li>
				<li class="list-item">
					<a href="#" class="list-link">Memberships</a>
				</li>
			</ul>

		</div>

	</div>
	
</footer>
</body>
</html>
<style>
	/* Import font */
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap');

/* Custom properties */
:root{
    --light-color: #fff;
    --light-color-alt: #afb6cd;
    --primary-background-color: linear-gradient(red, green);
    --secondary-background-color: #252830;
    --hover-light-color: var(--light-color);
    --hover-dark-color: var(--primary-background-color);
    --gradient-color: linear-gradient(
        115deg,#4fcf70,#fad648,#a767e5,#12bcfe,#44ce7b);
    --transparent-light-color: rgba(255, 255, 255, 0.212);
    --transparent-dark-color: rgba(0,0,0,.75);
    --font-family: 'Poppins', sans-serif;
    --font-size-xsm: 1.2rem;
    --font-size-sm: 1.6rem;
    --font-size-md: 2.4rem;
    --font-size-lg: 3rem;
    --font-size-xl: 4rem;
    --gap: 2rem;
    --margin-sm: 2rem;
    --margin-md: 3rem;
    --item-min-height-sm: 20rem;
    --item-min-height-md: 30rem;
}

/* Base styles */
*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
	zoom: 95%;
}

html{
    font-size: 62.5%;
	
}

body{
    font-family: var(--font-family);
    font-size: var(--font-size-sm);
    color: var(--light-color-alt);
    background: linear-gradient(rgb(2 6 23),rgb(30 41 59));
    letter-spacing: 1px;
    transition: background-color .25s,color .25s;
	
}

a{
    color: inherit;
    text-decoration: none;
}

ul{
    list-style: none;
}

img{
    max-width: 100%;
}

input,
button {
  font: inherit;
  color: inherit;
  border: none;
  background-color: transparent;
}

i{
    font-size: var(--font-size-md);
}

/* Reusable classes */
.container{
    max-width: 160rem;
    margin: 0 auto;
    padding: 0 1.5rem;
}

.place-items-center{
    display: inline-flex;
    align-items: center;
    justify-content: center;
}

.section:not(.featured-articles){
    padding-block: 5rem;
}

.d-grid{
    display: grid;
}


/* Header */
.header{
    background-color: var(--secondary-background-color);
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    z-index: 999;
}


.logo{
    font-size: var(--font-size-md);
    color: var(--light-color);
}



.list{
    display: flex;
    align-items: center;
    gap: var(--gap);
}



.btn{
    cursor: pointer;
}

.list-link:hover,
.btn:hover,


/* Search */

.form-container-inner{
    margin: auto;
    display: flex;
    flex-direction: column;
    gap: var(--gap);
    text-align: center;
}

.form{
    display: flex;
    justify-content: center;
}

.form-input,
.form-btn{
    display: inline-block;
    outline: none;
    border: 2px solid var(--secondary-background-color);
    padding: 1.5rem;
    color: var(--light-color-alt);
}

.form-input{
    border-right: none;
    width: 100%;
    background-color: var(--primary-background-color);
}

.form-btn{
    margin-left: -.5rem;
    border-left: none;
    background-color: var(--secondary-background-color);
    text-transform: uppercase;
    width: 8rem;
}

.form-note{
    font-size: var(--font-size-xsm);
    align-self: flex-end;
}

.form-close-btn{
    position: absolute;
    top: 1.5rem;
    right: 1.5rem;
    border: 2px solid var(--secondary-background-color);
    width: 4rem;
    height: 4rem;
    display: flex;
}



/* Featured articles */
.featured-articles{
    padding-block: 2rem;
}

.section-header-offset{
    padding-top:3.5em;
}

.featured-articles-container,
.featured-content{
    gap: var(--gap);
}

.headline-banner{
    background-color: var(--secondary-background-color);
    display: flex;
    align-items: center;
    gap: var(--gap);
    font-size: var(--font-size-xsm);
}

.headline{
    background-color: #000;
    color: var(--light-color);
    font-size: 1rem;
    text-transform: uppercase;
    text-align: center;
    letter-spacing: 1px;
    padding: 4px;
    height: 100%;
}

.headline span{
    height: inherit;
}

.fancy-border{
    position: relative;
    overflow: hidden;
}

.fancy-border::before{
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    width: 200%;
    height: 100%;
    background: var(--gradient-color);
    background-size: 50% 100%;
    z-index: 5;
}

.fancy-border span{
    position: relative;
    z-index: 10;
    display: inline-flex;
    background-color: var(--secondary-background-color);
    padding: .6rem 1.5rem;
	scale:0.95;
}

.article{
    position: relative;
    min-height: var(--item-min-height-md);
}

.article-image{
    position: absolute;
    width: 100%;
    height: 100%;
    object-fit: cover;
    transition: transform .25s;
}

.article-category{
    position: absolute;
    top: 1rem;
    right: 1rem;
    padding: 1rem;
    background-color:var(--primary-background-color);
    font-size: 1rem;
    color: var(--light-color);
    text-transform: uppercase;
    z-index: 10;
}

.article-data-container{
    width: 100%;
    position: absolute;
    left: 0;
    bottom: 0;
    padding: 2rem 1.5rem;
    background-color: var(--transparent-dark-color);
    z-index: 10;
    transition: background-color .5s;
}

/* Light theme color hover styles */
.article:hover .article-data-container{
    background-color: var(--hover-dark-color);
    color: var(--hover-light-color);
}

.article:hover .article-data-spacer{
    background-color: var(--hover-light-color);
}

.article:hover .article-title{
    color: var(--hover-light-color);
}


.article-data{
    display: flex;
    align-items: center;
    gap: var(--gap);
    font-size: var(--font-size-xsm);
    margin-bottom: 1rem;
}

.article-data-spacer{
    width: .5rem;
    height: .5rem;
    background-color: var(--light-color-alt);
    transform: rotate(45deg);
}

.title{
    color: var(--light-color);
}

.article-title{
    font-size: var(--font-size-md);
}

/* Sidebar */
.sidebar{
    background-color: var(--secondary-background-color);
    padding: 2.5rem;
}

.trending-news-box{
    display: flex;
    flex-direction: column;
    gap: var(--gap);
    padding-block: 2rem;
    border-bottom: 1px solid var(--transparent-light-color);
}

.trending-news-box:last-of-type{
    border-bottom: none;
}

.featured-content-title{
    font-size: var(--font-size-md);
    text-align: center;
    padding: 1rem;
}

.trending-news-img-box{
    position: relative;
    width: 100%;
    height: var(--item-min-height-sm);
}

.trending-number{
    position: absolute;
    top: -1rem;
    left: -1rem;
    z-index: 15;
    width: 3rem;
    height: 3rem;
    background-color: var(--secondary-background-color);
    color: var(--light-color);
    border-radius: 50%;
}

.trending-news-data .article-title{
    font-size: var(--font-size-sm);
}

.trending-news-box:hover .article-title{
    color: var(--light-color-alt);
}

/* Quick read */
.section-title{
    position: relative;
    font-size: var(--font-size-md);
    margin-bottom: 6rem;
}

.section-title::after{
    content: attr(data-name);
    font-size: var(--font-size-lg);
    text-transform: uppercase;
    opacity: .1;
    position: absolute;
    top: 1.5rem;
    left: 2rem;
}



/* Older posts */
.older-posts-grid-wrapper{
    gap: var(--gap);
}

.older-posts-article-image-wrapper,
.older-posts .article{
    min-height: var(--item-min-height-sm);
}

.older-posts .article{
    background-color: var(--secondary-background-color);
}

.older-posts-article-image-wrapper{
    position: relative;
}

.older-posts-grid-wrapper .article-data-container{
    position: static;
    background-color: transparent;
}

.older-posts-grid-wrapper .article-title{
    margin-bottom: var(--margin-sm);
}



.popular-tags-container .article:hover .article-image{
    transform: scale(1.05);
}

/* Newsletter */
.newsletter{
    padding-bottom: 6rem;
}

.newsletter-title{
    font-size: var(--font-size-lg);
}

.newsletter-description{
    margin-bottom: 3rem;
}

/* Footer */
.footer{
    background-color: var(--secondary-background-color);
}


.company-data{
    display: flex;
    flex-direction: column;
    order: 1;
}

.company-description{
    margin-block: var(--margin-sm);
    max-width: 75%;
}

.social-media{
    margin-bottom: var(--margin-md);
}

.copyright-notice{
    opacity: .8;
}

.footer-list{
    flex-direction: column;
    align-items: flex-start;
}

.footer-title{
    font-size: var(--font-size-sm);
    text-transform: uppercase;
    margin-bottom: var(--margin-sm);
}

/* Scrollbar */
::-webkit-scrollbar {
    width: 1rem;
}
  
::-webkit-scrollbar-track {
    background: #f1f1f1;
}
  
::-webkit-scrollbar-thumb {
    background: #3f4254;
}
  
::-webkit-scrollbar-thumb:hover {
    background: #2e303b;
}


@media screen and (min-width: 700px) {

    .trending-news-box{
        flex-direction: row;
        align-items: center;
    }

    .trending-news-img-box{
        width: 50%;
    }

    .trending-news-data{
        margin: auto;
        text-align: center;
    }
    
    .newsletter-description{
        max-width: 40rem;
    }

    .form-container-inner{
        align-items: center;
    }

   

    .company-data{
        order: 0;
    }

    
}

@media screen and (min-width: 768px) {

    .featured-content{
        grid-template-columns: repeat(4, 1fr);
        grid-template-rows: 5rem repeat(4, 1fr);
    }

    .headline-banner{
        grid-column: 1/-1;
        font-size: var(--font-size-sm);
    }
    
    .featured-article{
        grid-column: 3/-1;
        grid-row: 2/4;
    }

    .featured-article-1{
        grid-column: 1/3;
    }
    
    .featured-article-3{
        grid-column: 1/-1;
        grid-row: 4/6;
    }

    .older-posts .article{
        grid-template-columns: 25rem 1fr;
        
    }

    .older-posts-article-image-wrapper{
        height: auto;
    }

  
}

@media screen and (min-width: 1024px) {


    @keyframes animate_border{
        to{
            transform:translateX(-50%)
        }
    }

    .featured-articles-container{
        grid-template-columns: 1fr 40rem;
    }

    .trending-news-img-box{
        width: 10rem;
        height: 10rem;
    }



    .footer-container{
        grid-template-columns: repeat(5, 1fr);
    }

    .company-data{
        grid-column: span 2;
    }

    .company-description{
        max-width: 85%;
    }

    .copyright-notice{
        margin-top: auto;
    }

   
}

@media screen and (min-width: 1200px) {
    .older-posts-grid-wrapper{
        grid-template-columns: repeat(2, 1fr);
    }
}
@media screen and (min-width: 1500px) {
    .featured-article{
        grid-column: 3/-1;
    }
    
    .featured-article-1{
        grid-column: 1/3;
        grid-row: 2/-1;
    }

}
</style>