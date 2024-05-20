import React, { useEffect, useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

const UserAdd = () => {
  const initialFormState = {
    id: '',
    username: '',
    email: '',
    firstName: '',
    lastName: '',
    password: ''
  };
  const [user, setUser] = useState(initialFormState);
  const navigate = useNavigate();
  const { id } = useParams();

  useEffect(() => {}, [id, setUser]);

  const handleChange = (event) => {
    const { name, value } = event.target

    setUser({ ...user, [name]: value })
  }

  const handleSubmit = async (event) => {
    event.preventDefault();

    await fetch(`/api/users/create`, {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(user)
    });
    setUser(initialFormState);
    navigate('/users');
  }

  const title = <h2>Add User</h2>;

  return (<div>
      <AppNavbar/>
      <Container>
        {title}
        <Form onSubmit={handleSubmit}>
          <FormGroup>
            <Label for="id">id</Label>
            <Input type="number" name="id" id="id" value={user.id || ''}
                   onChange={handleChange} autoComplete="id"/>
          </FormGroup>
          <FormGroup>
            <Label for="username">username</Label>
            <Input type="text" name="username" id="username" value={user.username || ''}
                   onChange={handleChange} autoComplete="username"/>
          </FormGroup>
          <FormGroup>
            <Label for="email">email</Label>
            <Input type="text" name="email" id="email" value={user.email || ''}
                   onChange={handleChange} autoComplete="email"/>
          </FormGroup>
          <FormGroup>
            <Label for="firstName">first name</Label>
            <Input type="text" name="firstName" id="firstName" value={user.firstName || ''}
                   onChange={handleChange} autoComplete="firstName"/>
          </FormGroup>
          <FormGroup>
            <Label for="lastName">last name</Label>
            <Input type="text" name="lastName" id="lastName" value={user.lastName || ''}
                   onChange={handleChange} autoComplete="lastName"/>
          </FormGroup>
          <FormGroup>
            <Label for="password">password</Label>
            <Input type="text" name="password" id="password" value={user.password || ''}
                   onChange={handleChange} autoComplete="password"/>
          </FormGroup>
          <FormGroup>
            <Button color="primary" type="submit">Save</Button>{' '}
            <Button color="secondary" tag={Link} to="/users">Cancel</Button>
          </FormGroup>
        </Form>
      </Container>
    </div>
  )
};

export default UserAdd;
