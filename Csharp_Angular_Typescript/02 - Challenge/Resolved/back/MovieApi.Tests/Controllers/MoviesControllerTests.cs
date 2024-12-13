using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using MovieApi.Controllers;
using MovieApi.Data;
using MovieApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Xunit;

namespace MovieApi.Tests.Controllers
{
    public class MoviesControllerTests : IDisposable
    {
        private readonly DbContextOptions<MovieContext> _options;
        private readonly MoviesController _controller;
        private readonly MovieContext _context;

        public MoviesControllerTests()
        {
            _options = new DbContextOptionsBuilder<MovieContext>()
                .UseInMemoryDatabase(databaseName: "MovieDatabase")
                .Options;
            _context = new MovieContext(_options);
            _controller = new MoviesController(_context);
        }

        [Fact]
        public async Task GetMovies_ReturnsAllMovies()
        {
            // Arrange
            var movies = new List<Movie> { 
                new Movie { Id = 1, Title = "Movie 1", Director = "abc", ReleaseDate = new System.DateTime(2021, 1, 1) }, 
                new Movie { Id = 2, Title = "Movie 2", Director = "def", ReleaseDate = new System.DateTime(2020, 1, 1) } 
            };
            await _context.Movies.AddRangeAsync(movies);
            await _context.SaveChangesAsync();

            // Act
            var result = await _controller.GetMovies();

            // Assert
            var actionResult = Assert.IsType<ActionResult<IEnumerable<Movie>>>(result);
            var returnValue = Assert.IsType<List<Movie>>(actionResult.Value);
            Assert.Equal(2, returnValue.Count);
        }

        [Fact]
        public async Task GetMovie_ReturnsMovieById()
        {
            // Arrange
            var movie = new Movie { Id = 1, Title = "Movie 1", Director = "abc", ReleaseDate = new System.DateTime(2021, 1, 1) };
            await _context.Movies.AddAsync(movie);
            await _context.SaveChangesAsync();

            // Act
            var result = await _controller.GetMovie(1);

            // Assert
            var actionResult = Assert.IsType<ActionResult<Movie>>(result);
            var returnValue = Assert.IsType<Movie>(actionResult.Value);
            Assert.Equal(1, returnValue.Id);
        }

        [Fact]
        public async Task PostMovie_AddsNewMovie()
        {
            // Arrange
            var movie = new Movie { Id = 1, Title = "New Movie", Director = "abc", ReleaseDate = new System.DateTime(2021, 1, 1) };

            // Act
            var result = await _controller.PostMovie(movie);

            // Assert
            var actionResult = Assert.IsType<ActionResult<Movie>>(result);
            var createdAtActionResult = Assert.IsType<CreatedAtActionResult>(actionResult.Result);
            var returnValue = Assert.IsType<Movie>(createdAtActionResult.Value);
            Assert.Equal(1, returnValue.Id);

            var moviesInDb = await _context.Movies.ToListAsync();
            Assert.Single(moviesInDb);
            Assert.Equal("New Movie", moviesInDb[0].Title);
        }

        [Fact]
        public async Task PatchMovie_UpdatesExistingMovie()
        {
            // Arrange
            var movie = new Movie { Id = 1, Title = "Update Movie", Director = "abc", ReleaseDate = new System.DateTime(2021, 1, 1) };
            await _context.Movies.AddAsync(movie);
            await _context.SaveChangesAsync();
            movie.Title = "Updated Movie Title";

            // Act
            var result = await _controller.PatchMovie(1, movie);

            // Assert
            Assert.IsType<NoContentResult>(result);
            var updatedMovie = await _context.Movies.FindAsync(1);
            Assert.Equal("Updated Movie Title", updatedMovie.Title);
        }

        [Fact]
        public async Task DeleteMovie_RemovesMovieById()
        {
            // Arrange
            var movie = new Movie { Id = 1, Title = "Movie To Delete", Director = "abc", ReleaseDate = new System.DateTime(2021, 1, 1) };
            await _context.Movies.AddAsync(movie);
            await _context.SaveChangesAsync();

            // Act
            var result = await _controller.DeleteMovie(1);

            // Assert
            Assert.IsType<NoContentResult>(result);
            var deletedMovie = await _context.Movies.FindAsync(1);
            Assert.Null(deletedMovie);
        }

        /// <summary>
        /// Dispose the context after each test
        /// (Ensure the in-memory database is deleted)
        /// </summary>
        public void Dispose()
        {
            _context.Database.EnsureDeleted();
            _context.Dispose();
        }
    }
}