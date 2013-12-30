//Underscore {{...}}
_.templateSettings.interpolate = /\{\{(.+?)\}\}/g;

// models
var ContactModel = Backbone.Model.extend({});

// collections
var ContactCollection = Backbone.Collection.extend({
	model: ContactModel
});

// views
var ContactView = Backbone.View.extend({
	tagName : 'li',
	className : 'todo',
	template : _.template('{{first}} {{last}} - {{email}}'),
	render : function() {
		html = this.template(this.model.toJSON());
		this.$el.html(html);
		return this;
	}
});

var ContactListView = Backbone.View.extend({
	
	id: 'contact-list',
	tagName: 'ul',
	
	render: function(){
		this.addAll();
		return this;
	},
	
	addAll: function(){
		this.$el.empty();
		this.collection.forEach(this.addOne, this);
	},
	
	addOne: function(contact){
		var contactView = new ContactView({model: contact});
		this.$el.append(contactView.render().el);
	}
	
});

$(function() {
	
	// data 
	var data = [ {
		first : 'john',
		last : 'smith',
		email : 'jsmith@email.com'
	}, {
		first : 'jane',
		last : 'doe',
		email : 'jdoe@gmail.com'
	} ];


	// instances 
	var contactCollection = new ContactCollection(data);
	var contactListView = new ContactListView({ collection: contactCollection });
	contactListView.render();
	console.info(contactListView.el);
	
	$('#main').html(contactListView.el);
});
